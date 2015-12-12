package de.et.trips;

/**
 * A common property by which a group of trips is identified. This can be a single property of a trip or a combination
 * of several properties.
 *
 * @author Erik
 */
abstract class GroupProperty {

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}
