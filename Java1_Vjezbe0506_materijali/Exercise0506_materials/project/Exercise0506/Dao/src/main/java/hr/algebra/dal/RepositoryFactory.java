package hr.algebra.dal;

import hr.algebra.dal.file.FileRepository;

public class RepositoryFactory {

    private RepositoryFactory() {
    }

    private static Repository instance;

    public static Repository getInstance() throws Exception {
        if (instance == null) {
            instance = new FileRepository();
        }
        return instance;
    }

}
