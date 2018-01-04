# PhotoOrganizer

By group 12 aka:
Kiljunen, Olli Tuomas (olli.kiljunen@aalto.fi)
Pardo Muñoz, Edgar Ruben (edgar.pardomunoz@aalto.fi)
Rouhiainen, Tuukka Petteri (tuukka.rouhiainen@aalto.fi)
Saarnilehto, Ilkka Mathias (ilkka.saarnilehto@aalto.fi)
Saminathan, Kalaiarasan (kalaiarasan.saminathan@aalto.fi)

## Build

In root folder there is deploy.sh which

* Builds depug apk in `frontend/PhotoOrganizer/app/build/outputs/apk/debug/app-depug.apk`
* Deploys cloud functions
* Deploys backend
* Deploys cronjob

Before running script you need to run `chmod +x deploy.sh` to make it exucutable.

Enjoy!

## Directory structure of this repository

* `backend/`: contains the source code for the backend server application.
The backend server is written in Python using Flask framework.
* `firebase-functions/`: contains the source code of the Firebase Cloud
Functions written in Node.js.
* `frontend/`: contains the source code of the frontend app (PhotoOrganizer).
The frontend app is a native Android app written in Java.
* `doc/`: contains some *internal* documentation used in this project. It is
not intended to be read by others than developers and it is not necessarily
up-to-date.

## Known bugs

* It occasionally happens that a preview thumbnail of a photo is not displayed
correctly in the gallery of the Android app (instead, a gray box is shown).
Nonetheless, photos are correctly downloaded and they can be viewed in full
size by clicking them as normally. We don't know what causes this bug. Most
likely, it is an issue of Picasso library we used to load thumbnails from the
file system of the Android device. Had we had time, we would have tried to
replace Picasso with Glide to see if that fixes the issue.

* The expiration date of a group (in the Android app) is always represented
in the time zone of the server application. Furthermore, the expiration date
is shown more accurately than what would be reasonable.
