package repository;

import model.Batch;

import java.util.ArrayList;

public interface BatchRepository {
    ArrayList<Batch> batchList=new ArrayList<>();

    boolean save(Batch batch);

    boolean isBatch(String batchName);

    Batch fetchBatch(String batchName);
    boolean isQuestion(int questionNumber,Batch batch);
    boolean deleteQuestion(Batch batch,int questionNumber);
    ArrayList<Batch> getBatchList();
}
