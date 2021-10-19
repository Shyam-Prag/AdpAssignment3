package za.ac.cput.controllers;

/*
Author: Waseem Osman 216112338
Due Date:20 October 2021 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Statement;
import za.ac.cput.factory.StatementFactory;
import za.ac.cput.service.StatementService;
import java.util.List;


@RestController
@RequestMapping("/Statement")
public class StatementController {
    @Autowired
    private StatementService statementService;

    @PostMapping("/create")
    public Statement create(@RequestBody Statement statement){
        Statement newStatement1 = StatementFactory.buildStatement(statement.getId(),statement.getBalance(), statement.getFirstName(), statement.getLastName());
        return statementService.create(newStatement1);
    }

    @PostMapping("/read/{uuid}")
    public Statement read(@PathVariable String statementId){
        return statementService.read(statementId);
    }

    @PostMapping("/update")
    public Statement update(@RequestBody Statement statement) {
        return statementService.update(statement);
    }

    @PostMapping("/delete/{uuid}")
    public boolean delete(@PathVariable String statementId) {
        return statementService.delete(statementId);
    }

    @PostMapping("/getall")
    public List<Statement> getAll(){
        return statementService.getAll();
    }

}
