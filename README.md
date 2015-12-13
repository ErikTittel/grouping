# grouping
## Overview
Example algorithm that groups entities from a list.

Imagine you have a list of data records. For example trips from truck drivers. Every trip has certain attributes like
id, driver name, truck id, location and time of departure, etc.

Now you want to group those data records by certain attributes like all trips with the same driver and truck in a 
single group.

This project shows you how to do this.

## Technical Prerequisites
- Oracle Java 1.8.0_66
- Apache Maven 3.3.3 

## How to install
This is a pure java library. To install:

- clone this repo to your computer in a directory of your choice
- within this directory call `mvn clean install`

## How to use
- add a dependency to your own maven project

```xml
<dependency>
    <groupId>de.et</groupId>
    <artifactId>grouping</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

- in the package `de.et.trips` you now have three classes you can work with
    - `Trip` - the representation of a trip a truck driver takes to deliver goods
    - `TripGroup` - a group of trips identifies by a common property
    - `TripService` - the service you can call to group trips into groups

## Tests and examples
In the `TripServiceTest` you'll find a simple example showing you how the  grouping works.