
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Statement;
import za.ac.cput.repository.StatementRepository;

import java.util.List;

@Service
public class StatementService implements IStatementService {

    private static StatementService service = null;

    @Autowired
    private StatementRepository repository;

    @Override
    public Statement create(Statement statement) {
        return this.repository.save(statement);
    }

    @Override
    public Statement read(String uuid) {
        return this.repository.findById(uuid).orElse(null);
    }

    @Override
    public Statement update(Statement statement) {
        if(this.repository.existsById(statement.getId()))
            return this.repository.save(statement);
        return null;
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);

        if(this.repository.existsById(id))
            return false;
        else
            return true;
    }

    @Override
    public List<Statement> getAll() {
        return null;
    }

}

