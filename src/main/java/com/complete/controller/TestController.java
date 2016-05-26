package com.complete.controller;

import com.complete.domain.Contest;
import com.complete.domain.Solution;
import com.complete.domain.Task;
import com.complete.domain.User;
import com.complete.jsonview.SolutionView;
import com.complete.repository.ContestRepository;
import com.complete.repository.SolutionRepository;
import com.complete.repository.TaskRepository;
import com.complete.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Rina on 25.05.2016.
 */
@RestController
public class TestController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SolutionRepository solutionRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    ContestRepository contestRepository;

    /**
     * Generate token if login&pass is correct, and add to DB.
     * @param login
     * @param password
     * @return token
     * @see User
     */
    public String createToken(String login, String password) {
        // generate token
        Random random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);

        // add token to DB
        Iterable<User> users=userRepository.findByLoginAndPassword(login,password);
        for(User us: users) {
            userRepository.setTokenUserFor(token,us.getId());
        }

        return token;
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




    /*
    public Solution createSolution() {
        String code = code;
        Long timeSend = timeSend;
        Task task = createTask();
        User user = createUser();
        return new Solution()
    }
    */

    @RequestMapping(value="/user/test", method=RequestMethod.GET)
    public void userTest(
            @RequestParam ("firstName") String firstName,
            @RequestParam ("lastName") String lastName,
            @RequestParam ("login") String login,
            @RequestParam ("password") String password,
            @RequestParam ("group") String group)
    {
        User user = new User(firstName,lastName,group,login,password);
        userRepository.save(user);
        System.out.println(user);
    }
    @RequestMapping(value="/solution/test", method=RequestMethod.GET)
    public void solutionTest(
            @RequestParam ("code") String code,
            @RequestParam ("timeSend") Long timeSend,
            @RequestParam ("idTask") Long idTask,
            @RequestParam ("idUser") Long idUser,
            @RequestParam ("language") String language)
    {
        Solution solution = new Solution(timeSend,language, taskRepository.findOne(idTask), userRepository.findOne(idUser),code);
        solutionRepository.save(solution);
        System.out.println("nameTask "+solution.getTask().getNameTask());
    }

    @RequestMapping(value="/task/test", method=RequestMethod.GET)
    public void taskTest(
            @RequestParam ("nameTask") String nameTask,
            @RequestParam ("description") String description,
            @RequestParam ("note") String note,
            @RequestParam ("idContest") Long idContest)
    {
        Task task = new Task(nameTask,description,contestRepository.findOne(idContest));
        taskRepository.save(task);
        System.out.println("Name contest "+task.getContest().getNameContest());
    }

    @RequestMapping(value="/contest/test", method=RequestMethod.GET)
    public void taskTest(
            @RequestParam ("nameContest") String nameContest,
            @RequestParam ("duration") Long duration)
    {
        Contest contest = new Contest(nameContest, duration);
        contestRepository.save(contest);
    }




    @RequestMapping(value="/users", method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    @JsonView(SolutionView.SolView.class)
    @RequestMapping(value="/solutions", method = RequestMethod.GET)
    public Iterable<Solution> getAllSolutions() {
        System.out.println("ALL SOLUTIONS!!!");
        for(Solution s: solutionRepository.findAll()) {
            System.out.println(s);
            System.out.println("___***__");
        }

        return solutionRepository.findAll();
    }

    @RequestMapping(value="/solution/update", method = RequestMethod.GET)
    public void updateSolution() {
        System.out.println("Update Sol");
        Long score=Long.getLong("50");
        Long id=Long.getLong("2");;
       // solutionRepository.setSolutionScoreFor(score, id);
    }

}
