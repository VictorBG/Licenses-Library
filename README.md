# Licenses-Library

A simple library to show the list of licenses your app uses

![Image](https://raw.githubusercontent.com/VictorBG/Licenses-Library/master/screenshots/Screenshot_1508007030.png)![Image](https://raw.githubusercontent.com/VictorBG/Licenses-Library/master/screenshots/Screenshot_1508007049.png)

## Include in your project

```gradle
repositories {
    jcenter()
}

...

dependencies {
    compile 'com.vbg:licenses-library:1.0.2'
}
```

## Usage

1. Extend your licenses activity with `LicensesActivity`:

```java 
public class InfoLicensesActivity extends LicensesActivity 
```

2. Implement methods of ```LicensesActivity```:
```java
@Override
    public int getActivityStyle() {
        return DARK;
    }
```

With `getActivityStyle` you set the style of the licenses activity. The return must be `DARK` or `LIGHT`

3. Add the libraries. You can add the libraries with 2 forms:
    1. Calling the method `setLicenses(LicensesLibrary.Builder licenses)`
    2. Or overriding the method `setupLicenses()` like this:
```java
@Override
    public LicensesLibrary.Builder setupLicenses() {
        return new LicensesLibrary.Builder(this)
                .addLicense(new License("Android Open Source Project", "The Android Open Source Project", "2017", LicensesType.APACHE20));
    }
```

## Licenses

Licenses can be set manually (adding the entire license into strings and then creating a License object with only the name and the license string) 
or letting the library build the license for you, you only have to provide the name, the author, the year and the type of the license.

#### Normal license

```java
new License("ObservableScrollView", "Soichiro Kashima", "2014", LicensesType.APACHE20)
new License(name, author, year, license type)
````

#### Custom license
```java
new License("Custom license", R.string.example_license)
```

### License types available

| License name  |  LicenseType in the library|
| ------------- | ------------- |
| MIT  | LicenseType.MIT  |
| Apache 2.0  | LicenseType.APACHE20  |
| Creative Commons 3.0  | LicenseType.CC30  |
| BSD 2.0  | LicenseType.BSD2  |
| BSD 3.0  | LicenseType.BSD3  |

## Developed By

* [Víctor Blanco](http://victorblancogarcia.com)
* <victorblancogarcia3@gmail.com>

## License

    Copyright 2017 Victor Blanco

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


