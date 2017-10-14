package com.bootcamp;

import javax.persistence.*;
import org.testng.annotations.Test;
import java.util.*;

/**
 * Created by darextossa on 9/22/17.
 */
public class GenerateTableTest {

    //@Test
    public void generateTablesMysql() {
        Persistence.generateSchema("tpJpa", new Properties());
    }

    //@Test
    public void generateTablesDerby() {
        Persistence.generateSchema("com.bootcamp_TpJPA", new Properties());
    }
}
