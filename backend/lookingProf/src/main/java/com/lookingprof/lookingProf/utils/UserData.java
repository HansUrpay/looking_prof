package com.lookingprof.lookingProf.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserData {

    public List<Map<String, Object>> jsonData() throws JsonProcessingException {
        String json =  "[" +
                "{\"firstName\": \"Marcela\", \"lastName\": \"Fernández\", \"email\": \"marcelafernandez@gmail.com\", \"password\": \"hashed_password_1\"," +
                " \"phone\": \"+5491252985471\", \"address\": \"Calle Principal 2678\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709574374/LookingProf/roman-akhmerov-Js6Hwobewi8-unsplash_nss7qf.jpg\"," +
                "\"qualification\": 4, \"description\": \"Soy especialista en tal profesión y tengo tanto tiempo de experiencia\", \"city\": \"La Plata\"}," +
                "{ \"firstName\": \"Alejandro\", \"lastName\": \"García\", \"email\": \"alejandrogarcia@gmail.com\", \"password\": \"hashed_password_2\"," +
                "\"phone\": \"+5491887654321\", \"address\": \"Avenida Principal 123\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709574375/LookingProf/zahir-namane-hwc7eIQiTCE-unsplash_wwgny1.jpg\"," +
                "\"qualification\": 3, \"description\": \"Tengo experiencia en diferentes campos y estoy aquí para ayudarte.\", \"city\": \"San Fernando del Valle de Catamarca\"}," +
                "{ \"firstName\": \"María\", \"lastName\": \"Martínez\", \"email\": \"mariamartinez@gmail.com\", \"password\": \"hashed_password_3\", \"phone\": \"+5491122334455\"," +
                "\"address\": \"Calle Florida 567\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709574374/LookingProf/michael-dam-mEZ3PoFGs_k-unsplash_jymmcm.jpg\", \"qualification\": 5," +
                "\"description\": \"Soy apasionada por mi trabajo y me encanta ayudar a otros.\", \"city\": \"Resistencia\"}," +
                "{\"firstName\": \"Pedro\", \"lastName\": \"Rodríguez\", \"email\": \"pedrorodriguez@gmail.com\", \"password\": \"hashed_password_4\", " +
                "\"phone\": \"+5491556677889\", \"address\": \"Avenida Libertador 987\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709574374/LookingProf/man1_cauyob.jpg\"," +
                " \"qualification\": 4, \"description\": \"Especializado en resolver problemas de forma eficiente.\", \"city\": \"Rawson\"}," +
                "{\"firstName\":\"Sofía\",\"lastName\":\"García\",\"email\":\"sofiagarcia@gmail.com\",\"password\":\"hashed_password_6\"," +
                "\"phone\":\"+5491556677999\",\"address\":\"Avenida San Martín 123\",\"country\":\"Argentina\",\"imageUrl\":\"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709574374/LookingProf/jimmy-fermin-bqe0J0b26RQ-unsplash_ndf07h.jpg\"," +
                "\"qualification\":5,\"description\":\"Experiencia en resolver problemas complejos de manera efectiva.\",\"city\":\"Córdoba\"}," +
                "{\"firstName\": \"Carlos\", \"lastName\": \"González\", \"email\": \"carlosgonzalez@gmail.com\", \"password\": \"hashed_password_6\"," +
                "\"phone\": \"+5491777665544\", \"address\": \"Avenida San Martín 789\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709574374/LookingProf/joseph-gonzalez-iFgRcqHznqg-unsplash_wug3h8.jpg\"," +
                " \"qualification\": 3, \"description\": \"Siempre buscando nuevas formas de ayudar a mis clientes.\", \"city\": \"Corrientes\"}," +
                "{\"firstName\": \"Ana\", \"lastName\": \"Díaz\", \"email\": \"anadiaz@gmail.com\", \"password\": \"hashed_password_7\", " +
                "\"phone\": \"+5491223344556\", \"address\": \"Calle Corrientes 456\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709574374/LookingProf/guillaume-bolduc-wnA05v1BaNo-unsplash_rvgrnq.jpg\"," +
                " \"qualification\": 5, \"description\": \"Experta en resolver problemas complejos de manera eficiente.\", \"city\": \"Paraná\"}," +
                "{\"firstName\": \"Jorge\", \"lastName\": \"Hernández\", \"email\": \"jorgehernandez@gmail.com\", \"password\": \"hashed_password_8\"," +
                " \"phone\": \"+5491888776655\", \"address\": \"Avenida Belgrano 654\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709574374/LookingProf/jurica-koletic-7YVZYZeITc8-unsplash_koqqb4.jpg\"," +
                " \"qualification\": 4, \"description\": \"Comprometido en brindar la mejor calidad de servicio.\", \"city\": \"Formosa\"}," +
                "{\"firstName\": \"Laura\", \"lastName\": \"López\", \"email\": \"lauralopez@gmail.com\", \"password\": \"hashed_password_9\"," +
                " \"phone\": \"+5491443322110\", \"address\": \"Calle Maipú 890\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709574374/LookingProf/christina-wocintechchat-com-SJvDxw0azqw-unsplash_hbjhx8.jpg\"," +
                " \"qualification\": 4, \"description\": \"Enfocada en ofrecer soluciones personalizadas y efectivas.\", \"city\": \"San Salvador de Jujuy\"}," +
                "{\"firstName\": \"Martín\", \"lastName\": \"Martínez\", \"email\": \"martinmartinez@gmail.com\", \"password\": \"hashed_password_10\"," +
                " \"phone\": \"+5491554433221\", \"address\": \"Avenida Rivadavia 1234\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709574374/LookingProf/jack-finnigan-rriAI0nhcbc-unsplash_z70ssq.jpg\"," +
                " \"qualification\": 3, \"description\": \"Con experiencia en resolver una amplia gama de problemas.\", \"city\": \"Santa Rosa\"}," +
                "{\"firstName\": \"Carolina\", \"lastName\": \"Pérez\", \"email\": \"carolinaperez@gmail.com\", \"password\": \"hashed_password_11\"," +
                " \"phone\": \"+5491222334455\", \"address\": \"Calle Reconquista 432\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709574373/LookingProf/christina-wocintechchat-com-0Zx1bDv5BNY-unsplash_m59yca.jpg\"," +
                " \"qualification\": 5, \"description\": \"Especialista en encontrar soluciones innovadoras.\", \"city\": \"La Rioja\"}," +
                "{\"firstName\": \"Diego\", \"lastName\": \"Suárez\", \"email\": \"diegosuarez@gmail.com\", \"password\": \"hashed_password_12\"," +
                " \"phone\": \"+5491776655443\", \"address\": \"Avenida del Sol 876\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709574373/LookingProf/angelika-agibalova-06Bl5S7tySM-unsplash_havqpt.jpg\"," +
                " \"qualification\": 4, \"description\": \"Con habilidades para resolver problemas de manera rápida y precisa.\", \"city\": \"San Rafael\"}," +
                "{\"firstName\": \"Valentina\", \"lastName\": \"Gómez\", \"email\": \"valentinagomez@gmail.com\", \"password\": \"hashed_password_13\"," +
                " \"phone\": \"+5491888877766\", \"address\": \"Calle Sarmiento 345\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709574373/LookingProf/aiony-haust-3TLl_97HNJo-unsplash_fu1qxc.jpg\"," +
                " \"qualification\": 4, \"description\": \"Con habilidades para resolver problemas de manera rápida y precisa.\", \"city\": \"Posadas\"}" +
                "]"
        ;

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, List.class);
    }

    public List<Map<String, Object>> jsonData2() throws JsonProcessingException {
        String json = "[" +
                "{\"firstName\": \"Mónica\", \"lastName\": \"Velarde\", \"email\": \"monicavelarde@gmail.com\", \"password\": \"hashed_password_1\"," +
                " \"phone\": \"+5491252985471\", \"address\": \"Calle Principal 2678\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709768052/LookingProf/adam-winger-ZsUbK9zSgMo-unsplash_rxorlr.jpg\"," +
                " \"qualification\": 4, \"description\": \"Soy especialista en tal profesión y tengo tanto tiempo de experiencia\", \"city\": \"Bahía Blanca\"}," +
                "{\"firstName\": \"Juan\", \"lastName\": \"Pérez\", \"email\": \"juanperez@example.com\", \"password\": \"hashed_password_2\"," +
                " \"phone\": \"+5491123456789\", \"address\": \"Avenida Principal 123\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709768053/LookingProf/jimmy-nilsson-masth-xXytHCOv9ck-unsplash_myxx1j.jpg\"," +
                " \"qualification\": 5, \"description\": \"Soy experto en tal área y tengo experiencia en tal y tal\", \"city\": \"Andalgalá\"}," +
                "{\"firstName\": \"Carlos\", \"lastName\": \"Torres\", \"email\": \"carlostorres@example.com\", \"password\": \"hashed_password_3\"," +
                " \"phone\": \"+5491234567890\", \"address\": \"Calle Secundaria 456\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709768052/LookingProf/james-kovin-qqLxF3M-MA8-unsplash_ag4dy1.jpg\"," +
                " \"qualification\": 3, \"description\": \"Tengo experiencia en esta área y me gusta aprender cosas nuevas\", \"city\": \"Barranqueras\"}" +
                "]"
                ;

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, List.class);
    }

    public List<Map<String, Object>> jsonData3() throws JsonProcessingException {
        String json = "[" +
                "{\"firstName\": \"Ana\", \"lastName\": \"Martínez\", \"email\": \"anamartinez@example.com\", \"password\": \"hashed_password_4\"," +
                "\"phone\": \"+5491357924680\", \"address\": \"Avenida Central 789\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709768052/LookingProf/daria-pimkina-tYaccl19A3Q-unsplash_tc40ft.jpg\"," +
                "\"qualification\": 4, \"description\": \"Tengo experiencia en esta área y me gusta aprender cosas nuevas\", \"city\": \"Pinamar\"}," +
                "{\"firstName\": \"José\", \"lastName\": \"López\", \"email\": \"joselopez@example.com\", \"password\": \"hashed_password_5\"," +
                "\"phone\": \"+5491447952368\", \"address\": \"Calle Principal 456\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709768052/LookingProf/jimmy-nilsson-masth-LOtb6vKN3Ac-unsplash_ehkdj2.jpg\"," +
                "\"qualification\": 3, \"description\": \"Tengo experiencia en tal profesión y tengo tanto tiempo de experiencia\", \"city\": \"Belén\"}," +
                "{\"firstName\": \"Martín\", \"lastName\": \"García\", \"email\": \"martingarcia@example.com\", \"password\": \"hashed_password_6\"," +
                "\"phone\": \"+5491569874123\", \"address\": \"Avenida Secundaria 789\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709768052/LookingProf/ai-generated-8306280_640_hwqm4x.jpg\"," +
                "\"qualification\": 5, \"description\": \"Soy especialista en tal área y tengo tanto tiempo de experiencia\", \"city\": \"Presidencia Roque Sáenz Peña\"}" +
                "]"
                ;

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, List.class);
    }

    public List<Map<String, Object>> jsonData4() throws JsonProcessingException {
        String json = "[" +
                "{\"firstName\": \"Laura\", \"lastName\": \"Rodríguez\", \"email\": \"laurarodriguez@example.com\", \"password\": \"hashed_password_7\"," +
                "\"phone\": \"+5491789562341\", \"address\": \"Calle Secundaria 789\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709768052/LookingProf/helena-lopes-_SzvRwdFo6o-unsplash_cnznx8.jpg\"," +
                "\"qualification\": 4, \"description\": \"Tengo experiencia en esta área y me gusta aprender cosas nuevas\", \"city\": \"Tandil\"}," +
                "{\"firstName\": \"Diego\", \"lastName\": \"Hernández\", \"email\": \"pedrogomez@example.com\", \"password\": \"hashed_password_8\"," +
                "\"phone\": \"+5491998765432\", \"address\": \"Avenida Central 456\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709768053/LookingProf/ryno-marais-W4fQVj2iPpI-unsplash_tzwljv.jpg\"," +
                "\"qualification\": 3, \"description\": \"Soy experto en tal área y tengo experiencia en tal y tal\", \"city\": \"Tinogasta\"}," +
                "{\"firstName\": \"Isabel\", \"lastName\": \"Gómez\", \"email\": \"isabelhernandez@example.com\", \"password\": \"hashed_password_9\"," +
                "\"phone\": \"+5491897654321\", \"address\": \"Calle Principal 789\", \"country\": \"Argentina\", \"imageUrl\": \"https://res.cloudinary.com/dlq0ud8ly/image/upload/v1709768052/LookingProf/builder-5170548_640_izci5e.jpg\"," +
                "\"qualification\": 5, \"description\": \"Tengo experiencia en esta área y me gusta aprender cosas nuevas\", \"city\": \"Villa Ángela\"}" +
                "]"
                ;

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, List.class);
    }

}