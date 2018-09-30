package com.ssm.toyrobot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to set the size of the board.
 *
 * @author  Sunitha Mudumba
 * @version 1.0
 * @since   2018-09-30
 */

@Configuration
@ConfigurationProperties(prefix = "toyrobot")
public class BoardProperties {

    private int colSize;
    private int rowSize;

    public int getColSize() {
        return colSize;
    }

    public void setColSize(int colSize) {
        this.colSize = colSize;
    }

    public int getRowSize() {
        return rowSize;
    }

    public void setRowSize(int rowSize) {
        this.rowSize = rowSize;
    }
}
