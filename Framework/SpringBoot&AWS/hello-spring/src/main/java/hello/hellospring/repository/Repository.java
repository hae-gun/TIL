package hello.hellospring.repository;

import hello.hellospring.domain.Member;

public interface Repository {
    public Member findById(Long id);
    public void add(Seller seller);
    public void update(Seller seller);
    public void remove(Seller seller);
}
