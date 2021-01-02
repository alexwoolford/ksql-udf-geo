# ksql-udf-geo

A collection of ksqlDB user-defined geo functions.

* geohash

## geohash

    ksql> SELECT
    > GEO_RESP_LATITUDE,
    > GEO_RESP_LONGITUDE,
    > GEOHASH(GEO_RESP_LATITUDE, GEO_RESP_LONGITUDE, 12) AS GEOHASH_12
    >FROM CONN EMIT CHANGES;
    +----------------------------+----------------------------+----------------------------+
    |GEO_RESP_LATITUDE           |GEO_RESP_LONGITUDE          |GEOHASH_12                  |
    +----------------------------+----------------------------+----------------------------+
    |45.8491                     |-119.7143                   |c24ugfddqesn                |
    |null                        |null                        |null                        |
    |37.751                      |-97.822                     |9ydqy025w0qn                |
    |39.6514                     |-104.9926                   |9xj3df6dphen                |
    |39.997                      |-105.0974                   |9xj783nrmj4w                |
    |37.751                      |-97.822                     |9ydqy025w0qn                |
    ^CQuery terminated


