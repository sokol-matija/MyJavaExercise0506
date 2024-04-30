/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal;

import hr.algebra.dal.sql.SqlRepository;

/**
 *
 * @author dnlbe
 */
public class RepositoryFactory {

    private static Repository repository;

    private RepositoryFactory() {
    }
    // LAZY SINGLETON
    public static Repository getRepository() throws Exception {
        if (repository == null) {
            //repository = new FileRepository();
            repository = new SqlRepository();
        }
        return repository;
    }
}
