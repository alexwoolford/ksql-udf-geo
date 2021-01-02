package io.woolford.kafka.ksql;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;


@UdfDescription(
        name = "geohash",
        description = "Get geohash for lat/lon"
)
public class Geohash {

    @Udf(description = "get geohash for lat/lon and number of characters")
    public String getGeohash(@UdfParameter(value = "lat", description = "latitude") final Double lat,
                             @UdfParameter(value = "lon", description = "longitude") final Double lon,
                             @UdfParameter(value = "numberOfCharacters", description = "number of characters (1-12)") final Integer numberOfCharacters) {

        return ch.hsr.geohash.GeoHash.geoHashStringWithCharacterPrecision(lat, lon, numberOfCharacters);

    }

}
