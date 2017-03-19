package com.nan.acountclient.ui.add;

import com.nan.acountclient.base.BasePresenter;
import com.nan.acountclient.base.BaseView;
import com.nan.acountclient.entity.Bill;

/**
 * Created by wzn on 2017/3/5.
 */

public class AddAccountContract {
     interface View extends BaseView{
         void saveSuccess(Bill bill);
     }

     interface Presenter extends BasePresenter<View>{
        void saveBill(double money,int tagId,String remark);
    }
}
