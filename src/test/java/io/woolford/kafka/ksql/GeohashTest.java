package io.woolford.kafka.ksql;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GeohashTest {

    private Geohash udf;
    @Before
    public void setUp() {
        udf = new Geohash();
    }

    @Test
    public void geohashHappyPathTest() {

        assertEquals("9", udf.getGeohash(39.99526, -105.0963652, 1) );
        assertEquals("9x", udf.getGeohash(39.99526, -105.0963652, 2) );
        assertEquals("9xj782zj", udf.getGeohash(39.99526, -105.0963652, 8) );
        assertEquals("9xj782zjm0y5", udf.getGeohash(39.99526, -105.0963652, 12) );

    }

    @Test (expected = IllegalArgumentException.class)
    public void geohashTooManyCharactersTest() {
        udf.getGeohash(39.99526, -105.0963652, 13);
    }

    @Test
    public void geohashZeroCharactersTest() {
        assertEquals("", udf.getGeohash(39.99526, -105.0963652, 0) );
    }

    @Test (expected = IllegalArgumentException.class)
    public void geohashBadLatLonTest() {
        udf.getGeohash(3000.0, 3000.0, 12);
    }

}
