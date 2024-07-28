package com.shadaan.pub_sub;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * @author shadaan5212
 **/
@Component
public class ConsumeMessage {

    //listens to message coming from publish-topic and writes it to output.txt file.
    @Bean
    public Consumer<String> consumer(){
        return (message)->{
            System.out.println("Received message:" + message);
            File file = new File("output.txt");
            try {
                file.createNewFile();
                FileWriter writer = new FileWriter("output.txt");
                writer.write(message);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
