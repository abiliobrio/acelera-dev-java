package com.challenge.suite;

import java.util.Set;
import org.reflections.Reflections;
import org.reflections.scanners.Scanner;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;
import javax.persistence.Column;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.GenerationType;
import java.util.function.Function;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import org.springframework.data.annotation.CreatedDate;
import java.util.Optional;
import java.util.Collection;
import javax.persistence.OneToMany;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.Assert;
import org.hamcrest.Matchers;
import javax.persistence.ManyToOne;
import javax.persistence.EntityListeners;
import org.junit.Test;
import javax.persistence.Entity;

public abstract class ClassTest
{
    public static final String CREATED_AT = "created_at";
    public static final String UNDERSCORE = "_";
    public static final String EMPTY = "";
    public static final String EMPTY_CONSTRUCTOR_NOTFOUND_MESSAGE = "N\u00e3o foi poss\u00edvel encontrar construtor vazio";
    public static final String DEFAULT_PACKAGE = "com.challenge.entity.";
    private Object object;
    
    public ClassTest() {
        this.object = null;
    }
    
    protected abstract int manyToOnes();
    
    protected abstract int oneToManys();
    
    public String getClassName() {
        return this.newObject().getClass().getSimpleName();
    }
    
    public abstract String getTableName();
    
    @Test
    public void isEntity() {
        this.assertAnnotationClass(Entity.class);
    }
    
    @Test
    public void isEntityListener() {
        this.assertAnnotationClass(EntityListeners.class);
    }
    
    @Test
    public void checkManyToOneFieldsQuantity() {
        final List<Field> manyToOneFields = this.findFieldsAnnotatedBy(ManyToOne.class);
        Assert.assertThat((Object)manyToOneFields, Matchers.hasSize(this.manyToOnes()));
    }
    
    @Test
    public void oneToManyFieldsFieldsAreCollection() {
        this.findFieldsAnnotatedBy(OneToMany.class).forEach(f -> Assert.assertThat((Object)Collection.class.isAssignableFrom(f.getType()), Matchers.equalTo((Object)true)));
    }
    
    @Test
    public void verifyTableName() {
        if (this.getClassName().toLowerCase().equals(this.getTableName())) {
            return;
        }
        if (this.isAnnotationPresent()) {
            Assert.assertThat((Object)this.newObject().getClass().getAnnotation(Entity.class).name(), Matchers.equalTo((Object)this.getTableName()));
        }
        else {
            Assert.assertThat((Object)true, Matchers.equalTo((Object)false));
        }
    }
    
    @Test
    public void checkOneToManyFieldsQuantity() {
        final List<Field> oneToManyFields = this.findFieldsAnnotatedBy(OneToMany.class);
        Assert.assertThat((Object)oneToManyFields, Matchers.hasSize(this.oneToManys()));
    }
    
    @Test
    public void hasColumnCreatedAt() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("created_at");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnCreatedAtWithAnnotationCreatedDate() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("created_at");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)field.get().isAnnotationPresent((Class<? extends Annotation>)CreatedDate.class), Matchers.equalTo((Object)true));
    }
    
    protected Boolean fieldIsNotNull(final Optional<Field> field) {
        return field.map(f -> f.isAnnotationPresent((Class<? extends Annotation>)NotNull.class)).orElse(false);
    }
    
    protected Boolean fieldHasSize(final Optional<Field> field, final int size) {
        return field.map(f -> f.getAnnotation(Size.class)).map(a -> a.max() == size).orElse(false);
    }
    
    protected Optional<Field> findByFieldNameOrColumnName(final String columnName) {
        return Optional.ofNullable(this.findFieldByName(columnName.replace("_", "")).orElseGet(() -> this.findFieldByColumnName(columnName).orElse(null)));
    }
    
    protected void verifyIdWithCorretStrategy() {
        final Optional<GeneratedValue> generatedValue = this.findFieldAnnotatedBy(GeneratedValue.class).map(f -> f.getAnnotation(GeneratedValue.class));
        Assert.assertThat((Object)generatedValue.isPresent(), Matchers.notNullValue());
        Assert.assertThat(generatedValue.map((Function<? super GeneratedValue, ?>)GeneratedValue::strategy).orElse(null), Matchers.equalTo((Object)GenerationType.IDENTITY));
    }
    
    private boolean isAnnotationPresent() {
        return this.newObject().getClass().isAnnotationPresent((Class<? extends Annotation>)Entity.class);
    }
    
    protected Optional<Field> findFieldByName(final String fieldName) {
        return Stream.of(this.newObject().getClass().getDeclaredFields()).filter(field -> field.getName().equalsIgnoreCase(fieldName)).findFirst();
    }
    
    protected <T extends Annotation> Optional<Field> findFieldAnnotatedBy(final Class<T> annotation) {
        return Stream.of(this.newObject().getClass().getDeclaredFields()).filter(field -> field.isAnnotationPresent(annotation)).findFirst();
    }
    
    protected <T extends Annotation> List<Field> findFieldsAnnotatedBy(final Class<T> annotation) {
        return Stream.of(this.newObject().getClass().getDeclaredFields()).filter(field -> field.isAnnotationPresent(annotation)).collect((Collector<? super Field, ?, List<Field>>)Collectors.toList());
    }
    
    protected <T extends Annotation> List<Annotation> findAnnotationFieldsAnnotatedBy(final Class<T> annotation) {
        return Stream.of(this.newObject().getClass().getDeclaredFields()).filter(field -> field.isAnnotationPresent(annotation)).map(field -> field.getAnnotation(annotation)).collect((Collector<? super Object, ?, List<Annotation>>)Collectors.toList());
    }
    
    private <T extends Annotation> void assertAnnotationClass(final Class<T> annotation) {
        Assert.assertThat((Object)this.newObject().getClass().isAnnotationPresent(annotation), Matchers.equalTo((Object)true));
    }
    
    protected Optional<Field> findFieldByColumnName(final String columnName) {
        return this.findFieldsAnnotatedBy(Column.class).stream().filter(a -> a.getAnnotation(Column.class).name().equalsIgnoreCase(columnName)).findFirst();
    }
    
    protected Boolean isClassnameOrEntityWithName(final Class clazz, final String name) {
        final Entity entity = clazz.getAnnotation(Entity.class);
        return clazz.getSimpleName().equalsIgnoreCase(name) || entity.name().equalsIgnoreCase(name);
    }
    
    public Object newObject() {
        if (this.object == null) {
            try {
                return this.object = Stream.of(this.getClassByNameOrTableName(this.getTableName()).getDeclaredConstructors()).filter(constructor -> constructor.getGenericParameterTypes().length == 0).findFirst().map((Function<? super Constructor<?>, ?>)this.newInstance()).orElseThrow(() -> new InvocationTargetException(null, "N\u00e3o foi poss\u00edvel encontrar construtor vazio"));
            }
            catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        return this.object;
    }
    
    protected <T extends Annotation> List<Field> findFieldsAnnotatedBy(final Class clazz, final Class<T> annotation) {
        return Stream.of(clazz.getDeclaredFields()).filter(field -> field.isAnnotationPresent(annotation)).collect((Collector<? super Field, ?, List<Field>>)Collectors.toList());
    }
    
    protected boolean hasManyToOneWithEntityName(final String name) {
        return this.findFieldsAnnotatedBy(ManyToOne.class).stream().anyMatch(f -> this.isClassnameOrEntityWithName(f.getType(), name));
    }
    
    protected boolean hasManyToOneWithEntityName(final Class clazz, final String name) {
        return this.findFieldsAnnotatedBy(clazz, ManyToOne.class).stream().anyMatch(f -> this.isClassnameOrEntityWithName(f.getType(), name));
    }
    
    protected boolean hasFieldWithEntityName(final Class clazz, final String name) {
        return Stream.of(clazz.getDeclaredFields()).anyMatch(f -> this.isClassnameOrEntityWithName(f.getType(), name));
    }
    
    protected boolean hasOneToManyWithEntityName(final String name) {
        final boolean isClassName;
        final boolean isEntityName;
        return this.findFieldsAnnotatedBy(OneToMany.class).stream().map(f -> this.getClassOfListField(f)).anyMatch(clazz -> {
            isClassName = clazz.getSimpleName().toLowerCase().contains(name);
            isEntityName = clazz.getAnnotation(Entity.class).name().equalsIgnoreCase(name);
            return isClassName || isEntityName;
        });
    }
    
    private Function<Constructor<?>, ?> newInstance() {
        final ReflectiveOperationException ex;
        ReflectiveOperationException e;
        return (Function<Constructor<?>, ?>)(c -> {
            try {
                return c.newInstance(new Object[0]);
            }
            catch (InstantiationException | IllegalAccessException | InvocationTargetException ex2) {
                e = ex;
                new RuntimeException(e);
                return null;
            }
        });
    }
    
    protected Class<?> getClassOfListField(final Field f) {
        return (Class<?>)((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0];
    }
    
    protected Class<?> getClassByNameOrTableName(final String className) {
        final Reflections reflections = new Reflections("com.challenge.entity.", new Scanner[0]);
        final Set<Class<?>> entities = (Set<Class<?>>)reflections.getTypesAnnotatedWith((Class)Entity.class);
        try {
            return entities.stream().filter(c -> c.getSimpleName().equalsIgnoreCase(className) || c.getAnnotation(Entity.class).name().equalsIgnoreCase(className)).findFirst().orElseThrow(() -> new ClassNotFoundException());
        }
        catch (ClassNotFoundException e) {
            new RuntimeException(e);
            return null;
        }
    }
}