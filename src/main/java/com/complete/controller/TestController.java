package com.complete.controller;

import com.complete.domain.Solution;
import com.complete.domain.User;
import com.complete.repository.SolutionRepository;
import com.complete.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rina on 25.05.2016.
 */
@RestController
public class TestController {
    @Autowired
    UserRepository userRepository;
    SolutionRepository solutionRepository;

    /**
     * Generate token if login&pass is correct, and add to DB.
     * @param login
     * @param password
     * @return token
     * @see User
     */
    public String createToken(String login, String password) {
        // generate token
        // add token to DB
        return "token";
    }

    /**
     * Check in DB login&pass equals
     * @param login
     * @param password
     * @return true - is equal, false - is not equal
     * @see User
     */
    public boolean isAuth(String login, String password) {
        return /* findLogAndPass() */ true;
    }

    /**
     * Check user's participate in contest
     * @param token
     * @return true/1 - is participate, false/0 - is not participate
     */
    public int isParticipate(String token) {        // int -> boolean
        return /*getUserPart*/ 1;
    }
    /**
     * Check authorization
     * @param login
     * @param password
     * @return token if valid values (login,pass); null if they are not correct
     * @see User
     */
    @RequestMapping(value="/authorization", method = RequestMethod.GET)
    public String getAuthToken(@RequestParam ("login") String login, @RequestParam ("password") String password) {
        if(isAuth(login,password)) {
            String token = createToken(login, password);
            return token;
        }
        return null;
    }

    /**
     * Get information about solution by id
     * @param id
     * @return user's solution
     * @see Solution
     */
    @RequestMapping(value="/solution/id", method=RequestMethod.GET)
    public Solution getSolutionById(@RequestParam("id") int id) {
        Solution solution=null;
        // get solution for id from DB
        return solution;
    }

    /**
     * Get all user's solutions
     * @param token
     * @return List of all solution by user
     * @see Solution
     */
    @RequestMapping(value="/solution/user", method=RequestMethod.GET)
    public List<Solution> getSolutionByUser(@RequestParam("token") String token) { //String -> Token
        List<Solution> solutions=new ArrayList<Solution>();
        // get list of solutions for user from DB
        return solutions;
    }

    /**
     * Check if user participate in contest
     * @param token
     * @return 1 - is participate, 0 is not participate
     * @see User
     */
    @RequestMapping(value="/user/participate", method=RequestMethod.GET)
    public int isUserParticipate(@RequestParam("token") String token) { //String -> Token
        return isParticipate(token);
    }

    @RequestMapping(value="/user/test", method=RequestMethod.GET)
    public void userTest() { //String -> Token
        User user = new User("Julia","ev","ava","uku","ulka");
        userRepository.save(user);
        Solution solution = new Solution();
        solutionRepository.save(solution);
        user.getSolution().add(solution);
    }


    @RequestMapping(value="/users", method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }
}
