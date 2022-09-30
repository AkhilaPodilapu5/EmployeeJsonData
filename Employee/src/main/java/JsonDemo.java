import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.json.Json;
import javax.json.JsonWriter;
import javax.json.stream.JsonGenerator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class JsonDemo {

    public static void main(String[] args) throws IOException {


            OutputStream fos = new FileOutputStream("sample.json");
            JsonGenerator jsonGenerator = Json.createGenerator(fos);


            Employee emp = JsonDemo.createEmployee();
            jsonGenerator.writeStartObject(); // {
            jsonGenerator.writeStartArray("data");
            for(String data: emp.getData()){
                    jsonGenerator.write("id", emp.getId()); // "id":123
                    jsonGenerator.write("name", emp.getName());
                    jsonGenerator.write("role", emp.getRole());
                    jsonGenerator.write("permanent", emp.isPermanent());
                    jsonGenerator.write(data);

            }
            jsonGenerator.writeEnd();


            jsonGenerator.writeStartArray("phoneNumbers"); //start of phone num array
            for(long num : emp.getPhoneNumbers()){
                    jsonGenerator.write(num);
            }
            jsonGenerator.writeEnd(); // end of phone num array
            jsonGenerator.writeEnd(); // }

            jsonGenerator.close();
}

        private static Employee createEmployee() {
                Employee emp = new Employee();
                emp.setData(new String[] {});
                emp.setName("data");
                emp.setId(100);
                emp.setName("David");
                emp.setPermanent(false);
                emp.setPhoneNumbers(new long[] { 123456, 987654 });
                emp.setRole("Manager");
                return emp;
        }


}
