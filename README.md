# <img src="https://what3words.com/assets/images/w3w_square_red.png" width="64" height="64" alt="what3words">&nbsp;w3w-android-design-library

## Introduction

A Jetpack compose design library based on Material3 to be used across what3words components and apps.

###### Color scheme, Material and What3words composables using W3W Theme
<p float="left">
    <img src="./images/sample_app_w3w_theme_day.png" width=30% height=30%>
    <img src="./images/sample_app_w3w_theme_night.png" width=30% height=30%>
</p>

###### Color scheme, Material and What3words composables using Material Theme
<p float="left">
    <img src="./images/sample_app_material_theme_day.png" width=30% height=30%>
    <img src="./images/sample_app_material_theme_night.png" width=30% height=30%>
</p>

## Installation

The artifact is available 
through [![Maven Central](https://img.shields.io/maven-central/v/com.what3words/w3w-android-design-library)](https://central.sonatype.com/artifact/com.what3words/w3w-android-design-library/)

### Android minimum SDK support

[![Generic badge](https://img.shields.io/badge/minSdk-24-green.svg)](https://developer.android.com/about/versions/nougat)

### Gradle

```
implementation 'com.what3words:w3w-android-design-library:2.0.0'
```

#### Snapshots
We deploy snapshot versions of the library to [Sonatype's snapshot repository](https://s01.oss.sonatype.org/content/repositories/snapshots/). These snapshots are generated after every merge to an Epic branch, providing an easy way to test the latest unreleased changes and upcoming updates without waiting for the next official version release.

To use snapshot versions in your project, add the snapshot repository to your Gradle script:

```
repositories {
    maven {
        url 'https://s01.oss.sonatype.org/content/repositories/snapshots/'
    }
}
```
Then, update your dependencies to use the snapshot version:

```
dependencies {
    implementation 'com.what3words:w3w-android-design-library:2.0.0-SNAPSHOT'
}
```
The latest snapshot versions are available [here](https://s01.oss.sonatype.org/content/repositories/snapshots/com/what3words/w3w-android-design-library/).

# Design library components

### [What3wordsAddressListItem](https://github.com/what3words/w3w-android-design-library/blob/main/design-library/src/main/java/com/what3words/design/library/ui/components/What3wordsAddressListItem.kt)

Composable function to display a list item representing a What3words address.  This composable provides a customizable and responsive way to display What3words address suggestions in a list with optional details such as nearest place, distance, and custom labels.

###### W3W Theme

<p float="left">
    <img src="./images/w3w_address_item_w3w_theme_day.png" width=30% height=30%>
    <img src="./images/w3w_address_item_w3w_theme_night.png" width=30% height=30%>
</p>

###### Material Theme

<p float="left">
    <img src="./images/w3w_address_item_material_theme_day.png" width=30% height=30%>
    <img src="./images/w3w_address_item_material_theme_night.png" width=30% height=30%>
</p>

### [What3wordsAddress](https://github.com/what3words/w3w-android-design-library/blob/main/design-library/src/main/java/com/what3words/design/library/ui/components/What3wordsAddress.kt)

What3words Address is a composable to display a What3words address. It offers customizable styles for text and colors, and utilizes responsive text to adjust to container sizes.

###### W3W Theme

<p float="left">
    <img src="./images/w3w_address_w3w_theme_day.png" width=30% height=30%>
    <img src="./images/w3w_address_w3w_theme_night.png" width=30% height=30%>
</p>

###### Material Theme

<p float="left">
    <img src="./images/w3w_address_material_theme_day.png" width=30% height=30%>
    <img src="./images/w3w_address_material_theme_night.png" width=30% height=30%>
</p>