package com.example.librarymanagement.daoRepository;

import javax.persistence.EntityManager;
import java.util.Objects;

public class OperationDAO {

    private static OperationDAO operationDAO;
    private EntityManager entity;

    private OperationDAO() {
    }

    public static OperationDAO getInstance() {
        if (Objects.isNull(operationDAO)) {
            operationDAO = new OperationDAO();
        }
        return operationDAO;
    }
}
