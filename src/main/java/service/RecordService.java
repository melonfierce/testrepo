package service;

import dao.DerbyDao;
import model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Austin on 2/19/2015.
 */
@Service
public class RecordService {

    @Autowired
    DerbyDao derbyDao;

    private static final List<String> jobTitles = Arrays.asList("Cook", "business analyst");

    public List<Record> getAllRecords() {
        return derbyDao.getAllRecords();
    }

    public List<Record> getRecordsByJobTitle() {
        return derbyDao.getRecordsWithIn(jobTitles);
    }


}
