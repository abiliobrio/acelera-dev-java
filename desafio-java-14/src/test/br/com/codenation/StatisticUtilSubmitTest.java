package test.br.com.codenation;

import org.junit.Assert;
import org.junit.Test;

import br.com.codenation.StatisticUtil;

public class StatisticUtilSubmitTest
{
    @Test
    public void testAverage() {
        Assert.assertEquals(3L, (long)StatisticUtil.average(new int[] { 1, 2, 3, 4, 5 }));
    }
    
    @Test
    public void testAverage1Element() {
        Assert.assertEquals(10L, (long)StatisticUtil.average(new int[] { 10 }));
    }
    
    @Test
    public void testAverage2Elements() {
        Assert.assertEquals(10L, (long)StatisticUtil.average(new int[] { 10, 10 }));
    }
    
    @Test
    public void testAverage2000Elements() {
        final int[] array = new int[2000];
        for (int i = 0; i < array.length; ++i) {
            array[i] = 10000;
        }
        Assert.assertEquals(10000L, (long)StatisticUtil.average(array));
    }
    
    @Test
    public void testAverageUnorderedArray() {
        final int[] array = { 5, 6, 3, 10, 5000, 399, 2, 0, 0, 0, 10 };
        Assert.assertEquals(494L, (long)StatisticUtil.average(array));
    }
    
    @Test
    public void testAverageWithNegativeNumbers() {
        final int[] array = { -10, -20, -10, -20 };
        Assert.assertEquals(-15L, (long)StatisticUtil.average(array));
    }
    
    @Test
    public void testAverageWithNegativeAndPositiveNumbers() {
        final int[] array = { -10, -20, -10, -20, 10, 20, 30, 10 };
        Assert.assertEquals(1L, (long)StatisticUtil.average(array));
    }
    
    @Test
    public void testMode() {
        Assert.assertEquals(3L, (long)StatisticUtil.mode(new int[] { 1, 2, 3, 3 }));
    }
    
    @Test
    public void testModeWithOnly1Number() {
        Assert.assertEquals(0L, (long)StatisticUtil.mode(new int[] { 0, 0, 0, 0, 0 }));
    }
    
    @Test
    public void testModeWithModeInArrayBegin() {
        Assert.assertEquals(0L, (long)StatisticUtil.mode(new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 2, 2 }));
    }
    
    @Test
    public void testModeWithModeInArrayEnd() {
        Assert.assertEquals(2L, (long)StatisticUtil.mode(new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 }));
    }
    
    @Test
    public void testModeWithNegativeMode() {
        Assert.assertEquals(-1L, (long)StatisticUtil.mode(new int[] { 0, 0, 0, 0, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 1, 2, 2 }));
    }
    
    @Test
    public void testModeWithModeInArrayMiddle() {
        Assert.assertEquals(0L, (long)StatisticUtil.mode(new int[] { 0, 2, 0, 3, 4, 0, 5, 10, 5, 3, 3, 0, 1, 3, 5, 0, 10, 22, 0, 32, 0, 0 }));
    }
    
    @Test
    public void testMedianWithOddArray() {
        Assert.assertEquals(3L, (long)StatisticUtil.median(new int[] { 1, 2, 3, 4, 5 }));
    }
    
    @Test
    public void testMedianWithOddUnorderedArray() {
        Assert.assertEquals(3L, (long)StatisticUtil.median(new int[] { 5, 2, 1, 4, 3 }));
    }
    
    @Test
    public void testMedianWithEvenArray() {
        Assert.assertEquals(3L, (long)StatisticUtil.median(new int[] { 1, 2, 3, 4, 5, 6 }));
    }
    
    @Test
    public void testMedianWithEvenArrayUnOrdered() {
        Assert.assertEquals(3L, (long)StatisticUtil.median(new int[] { 6, 5, 1, 3, 4, 2 }));
    }
    
    @Test
    public void testMedianWithEvenArrayUnOrderedAndNegativeNumbers() {
        Assert.assertEquals(-3L, (long)StatisticUtil.median(new int[] { -6, -5, -1, -3, -4, -2 }));
    }
    
    @Test
    public void testMedianWithOddUnorderedNegativeArray() {
        Assert.assertEquals(-3L, (long)StatisticUtil.median(new int[] { -5, -2, -1, -4, -3 }));
    }
    
    @Test
    public void testMedianWithOddArrayUnOrderedAndNegativeAndPositiveNumbers() {
        Assert.assertEquals(0L, (long)StatisticUtil.median(new int[] { 0, -1, -2, 1, 2 }));
    }
    
    @Test
    public void testMedianWithEvenArrayUnOrderedAndNegativeAndPositiveNumbers() {
        Assert.assertEquals(0L, (long)StatisticUtil.median(new int[] { 0, -1, -2, 1, 2, -3 }));
    }
}