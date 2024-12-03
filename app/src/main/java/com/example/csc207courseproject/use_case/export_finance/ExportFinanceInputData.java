package com.example.csc207courseproject.use_case.export_finance;

import java.io.File;

public class ExportFinanceInputData {
   public File file;

    /**
     * Construct a new ExportFinanceInputData with the given file.
     *
     * @param file the file to export.
     */
    public ExportFinanceInputData(File file) {
        this.file = file;
    }

    /**
     * Get the file.
     *
     * @return the file.
     */
    public File getFile() {
        return file;
    }

}
