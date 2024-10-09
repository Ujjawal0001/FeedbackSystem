package repository.impl;

import model.Batch;
import repository.BatchRepository;

import java.util.ArrayList;

public class BatchRepositoryImpl implements BatchRepository {
    public boolean save(Batch batch) {
        batchList.add(batch);
        return true;
    }

    public boolean isBatch(String batchName) {
        Batch batch=fetchBatch(batchName);
        return batch !=null;
    }

    public boolean isQuestion(int questionNumber,Batch batch){
        if(questionNumber>0 && questionNumber<=batch.getFeedbackTemplate().getQuestionList().size())
            return true;
        else return false;
    }

    public Batch fetchBatch(String batchName) {
        for(Batch batch: batchList){

            if(batch.getBatchName().equalsIgnoreCase(batchName))
                return batch;
        }
        return null;
    }

    public boolean deleteQuestion(Batch batch,int questionNumber){
        batch.getFeedbackTemplate().getQuestionList().remove(questionNumber-1);
        return true;
    }

    public ArrayList<Batch> getBatchList() {
        return batchList;
    }


}
