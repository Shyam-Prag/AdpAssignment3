package za.ac.cput.service;

import za.ac.cput.entity.Address;
import za.ac.cput.entity.Statement;

import java.util.List;

public interface IStatementService extends IService <Statement, String>{
    public List<Statement> getAll();

}
