package br.com.filipe.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by filipedosreis@gmail.com on 09/02/2017.
 */
public final class JsonImport {

    private JsonImport() {

    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static List getEntityList(String fileName, Class tipo) throws Exception {

        InputStream is = JsonImport.class.getResourceAsStream("/app/entities/" + fileName + ".json");

        BufferedReader br = null;
        final StringBuilder sb = new StringBuilder();

        String line;

        try {

            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        final ObjectMapper mapper = new ObjectMapper();
        List registros = mapper.readValue(sb.toString(), mapper.getTypeFactory().constructCollectionType(List.class, tipo));

        return registros;
    }

}
