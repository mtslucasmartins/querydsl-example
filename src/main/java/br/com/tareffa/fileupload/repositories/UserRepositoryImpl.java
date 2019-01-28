/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tareffa.fileupload.repositories;

import br.com.tareffa.fileupload.models.QUser;
import br.com.tareffa.fileupload.models.User;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    private QUser user = QUser.user;

    /* 
    Query Using CriteriaBuilder
    @Override
    public List<User> findUsersByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);

        Root<User> user = cq.from(User.class);
        Predicate authorNamePredicate = cb.equal(user.get("email"), email);
        cq.where(authorNamePredicate);

        TypedQuery<User> query = em.createQuery(cq);

        return query.getResultList();
    }  
     */
    @Override
    /* Query Using CriteriaBuilder */
    public List<User> findUsersByEmail(String email) {
        JPAQuery<User> query = new JPAQuery<User>(em).from(user)
                .where(user.email.eq(email));
        // return query.orderBy(cidade.name.asc()).fetch();
        return query.orderBy(user.email.desc()).fetch();
    }

}
