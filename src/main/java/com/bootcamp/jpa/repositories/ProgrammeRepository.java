/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositories;

import java.util.List;
import javax.persistence.Query;
import com.bootcamp.jpa.entities.*;

/**
 *
 * @author Iso-Doss
 */
public class ProgrammeRepository extends BaseRepository<Programme> {

    public ProgrammeRepository(String UnitPersistence) {
        super(UnitPersistence, Programme.class);
    }

    public List<Bailleur> getBailleursOfProgramme(Programme programme) {

        /*String className = getEntityClass().getClass().getSimpleName();
        String query = "select t from " + className + " t where t." + propertyName + "=:param";
        Query qry = getEm().createQuery(query);
        qry.setParameter("param", value);
        return (T) qry.getSingleResult();*/
        Query query = getEm().createQuery("select bailleurs from Programme programme join programme.bailleurs bailleurs where programme.id = :id");
        query.setParameter("id", programme.getId());
        return query.getResultList();
    }

    public List<Fournisseur> getFournisseursOfProgramme(Programme programme) {
        Query query = getEm().createQuery("select fournisseurs from Programme programme join programme.fournisseurs ournisseurs where programme.id = :id");
        query.setParameter("id", programme.getId());
        return query.getResultList();
    }

    public List<Beneficiaire> getBeneficiairesOfProgramme(Programme programme) {
        Query query = getEm().createQuery("select beneficiaires from Programme programme join programme.beneficiaires beneficiaires where programme.id = :id");
        query.setParameter("id", programme.getId());
        return query.getResultList();
    }

}
