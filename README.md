# Gyroskop & accelerometer
Denne artikel omhandler brugen af gyroskop og accelerometer.

## Forfattere
Denne gruppe består af følgende deltagere:
- Marco S. Blum
- Christian Lind

## The features
Accelerometer er en sensor som viser enhedens acceleration. Accelerationen er en 3d vektor og kan derfor hentes i 3 værdier, en for hver akse. accelerometeret kan derfor bruges til mange ting, som fx at se i hvilken retning enheden bevæger sig i.


Et gyroskop er en treakset bevægelsessensor, som er implementeret i telefonen for at kunne bestemme dens position.
De 3 akser indebærer at telefoner måler rotation i 3 forskellige retninger, der betegnes som x, y og z.
Ved at samle resultaterne fra de 3 retninger, kan det regnes ud, hvor stærk bevægelsen er og hvilken retning den har i de 3 dimensioner.


Når telefonen måler en bevægelse, skal den afgøre retningen for at bestemme hvordan brugerfladen skal vendes, eller om mobilen ligger med skærmen opad eller nedad.
Accelerometeret bruger accelerationen i de forskellige akser samt Jordens tyngdekraft som reference, til at måle hvilken vej enheden bevæger sig, men kan ikke bestemme orienteringen og hældningen særlig præcist. Gyroskopet har ansvaret for den resterende information accelerometeret mangler.


Gyroskop funktionen kan bruges til forskellige ting der omhandler hvordan din telefon er placeret, fx om den er lodret eller vandret. Et eksempel kunne være et spil hvor man skal løse en rubiks cube, og for at dreje cuben rundt, ville man tilte eller dreje telefonen i stedet. For at funktionen ikke ville irritere brugeren alt for meget, ville en ide være at implementere en knap der låser op for gyroskopet.


Kravet for at en gyroskop funktion eller accelerometer funktion kan fungerer, er android version 1.5, som blev indført i API level 3. Dette kommer ikke til at være et problem med telefoner nu til dags. Version 1.5 blev udgivet i 2009, og her i 2016 er vi allerede på version 7.
Derudover kræver det at telefonen også har en indbygget gyroskop og accelerometer enhed. 

## Eksempler i praksis
Gyroskop kan blive brugt til at trække en enhed, i 3d.
man henter rotationshastigheden, enheden drejer om sig selv i 3 akser.
```
val sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager;
val gyroscope = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
sm.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL)
```
Man laver en sensor manager, som laver en sensor.type.gyroscope hvilket kan bruges i en eventListener.

Accelerometer bruges til at trække en enheds acceleration i 3d, man kan hente accelerationen på 3 akser ligesom med gyroskopet, bare med sensor.type.accelerometer.
```
val sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager;
val accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
```

## Pitfalls and hacks
Det ville være nemmere, hvis man skal bruge flere forskellige sensorer, at lave en separat fil som bruges som eventlistener. I vores app, bruger den kun mainActivity.kt, og kan derfor ikke bruges til mere end 1 sensor, da onSensorChanged vil blive kørt hver gang en af sensorerne bliver ændret.
Accelerometeret og gyroskopet, vil der hele tiden lave mikroskobiske ændrigner og functionen  onSensorChanged vil derfor blive kørt konstant.

## Kildeliste
https://github.com/libgdx/libgdx/wiki/Accelerometer 

https://github.com/libgdx/libgdx/wiki/Gyroscope 

https://developer.android.com/guide/topics/manifest/uses-sdk-element.html#ApiLevels
