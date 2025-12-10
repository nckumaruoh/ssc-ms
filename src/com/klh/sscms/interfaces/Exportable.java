package com.klh.sscms.interfaces;

/**
 * Interface for exporting an object to CSV or display formats.
 */
public interface Exportable {

    /**
     * Converts object to a CSV line.
     * @return CSV formatted string
     */
    String toCsv();

    /**
     * Converts object to a readable format for display.
     * @return Human-friendly string
     */
    String toDisplayString();
}
