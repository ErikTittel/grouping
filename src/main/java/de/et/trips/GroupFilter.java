package de.et.trips;

/**
 * Reads the group property from a trip. Which specific GroupProperty will be returned is defined in the subtypes.
 * This interface acts as Abstract Factory for GroupProperties.
 *
 * @author Erik
 */
interface GroupFilter {

    GroupProperty readProperty(Trip trip);
}
