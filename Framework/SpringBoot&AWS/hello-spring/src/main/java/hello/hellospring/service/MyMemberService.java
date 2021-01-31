package hello.hellospring.service;

import hello.hellospring.repository.DatabaseRepository;

public class MyMemberService {

    private final DatabaseRepository repository;

    public MyMemberService(DatabaseRepository repository) {
        this.repository = repository;
    }
}
