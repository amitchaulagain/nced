package com.cms.repository;

import com.cms.model.Member;
import com.cms.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMemberDAO extends JpaRepository<Member, Integer>,
        JpaSpecificationExecutor<Member> {


    @Query("SELECT u FROM Member u WHERE u.training.id = :trainingId")
    List<Member> findAllMembersByTrainingId(@Param("trainingId") Integer trainingId);

    @Query("SELECT count(m) FROM Member m WHERE m.training.id=:id")
    int countNumberOfTrainees(@Param("id") Integer id);

    @Query("SELECT count(t) FROM Member t WHERE t.training.id=:id AND t.isMale=1")
    int countNumberOfMaleMembers(@Param("id") Integer id);

    /*
     * @Query("SELECT u FROM Role u WHERE LOWER(u.Rolename) = LOWER(:name)")
	 * Role retrieveByName(@Param("name") String name);
	 */
}
