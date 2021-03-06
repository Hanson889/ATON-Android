package com.juzix.wallet.component.ui.contract;

import com.juzix.wallet.component.ui.base.IPresenter;
import com.juzix.wallet.component.ui.base.IView;

import java.util.List;

/**
 * @author matrixelement
 */
public class VoteDetailContract {
    public static class Entity {
        public String name;
        public String candidateId;
        public long   createTime;
        public long   validVotes;
        public long   invalidVotes;
        public String ticketPrice;
        public double voteStaked;
        public double voteUnstaked;
        public double profit;
        public String walletAddress;
        public String walletName;
        public long   expirTime;
    }

    public interface View extends IView {
        String getCandidateIconFromIntent();
        String getCandidateIdFromIntent();
        String getCandidateNameFromIntent();
        void showCandidateInfo(int resIcon, String name, String candidateId);
        void updateTickets(List<Entity> entityList);
    }

    public interface Presenter extends IPresenter<View> {
        void start();
    }
}
