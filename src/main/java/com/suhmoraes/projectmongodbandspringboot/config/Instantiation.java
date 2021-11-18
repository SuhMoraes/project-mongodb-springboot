package com.suhmoraes.projectmongodbandspringboot.config;

import com.suhmoraes.projectmongodbandspringboot.dto.AuthorDTO;
import com.suhmoraes.projectmongodbandspringboot.dto.CommentsDTO;
import com.suhmoraes.projectmongodbandspringboot.model.Post;
import com.suhmoraes.projectmongodbandspringboot.model.User;
import com.suhmoraes.projectmongodbandspringboot.repository.PostRepository;
import com.suhmoraes.projectmongodbandspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll(); //--> Deleta os usuários inseridos
        postRepository.deleteAll();

        User fernanda = new User(null, "martinez@ermail.com", "Fernanda Martinez");
        User alex = new User(null, "alex_nascimento@ermail.com", "Alex Nascimento");
        User ruy  = new User(null, "rui@ermail.com", "Ruy Barbosa");

        userRepository.saveAll(Arrays.asList(fernanda, alex, ruy));

        Post post1 = new Post(null, new AuthorDTO(fernanda), sdf.parse("11/11/2021"), "Bora Estudar!!","Porque dinheiro não nasce em árvore.");
        Post post2 = new Post(null, new AuthorDTO(fernanda), sdf.parse("11/10/2021"), "Conhecendo uma nova stack.","Saindo do comodismo e aprendendo algo novo.");

        CommentsDTO c1 =  new CommentsDTO("É isso aí, sempre aprimorando os conhecimentos", sdf.parse("11/10/2021"), new AuthorDTO(alex));
        CommentsDTO c2 =  new CommentsDTO("O aprendizado nunca é demais", sdf.parse("13/10/2021"), new AuthorDTO(ruy));
        CommentsDTO c3 =  new CommentsDTO("O tempo passa estudando ou não. Então melhor estudar do que ver o tempo passar." , sdf.parse("11/10/2021"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        fernanda.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(fernanda);
    }
}
