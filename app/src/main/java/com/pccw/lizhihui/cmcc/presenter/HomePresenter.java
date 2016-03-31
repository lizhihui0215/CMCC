package com.pccw.lizhihui.cmcc.presenter;

import android.support.annotation.NonNull;

import com.pccw.lizhihui.cmcc.domain.HomeItem;
import com.pccw.lizhihui.cmcc.domain.interactor.DefaultSubscriber;
import com.pccw.lizhihui.cmcc.domain.interactor.HomeCase;
import com.pccw.lizhihui.cmcc.mapper.HomeModelDataMapper;
import com.pccw.lizhihui.cmcc.model.HomeModel;
import com.pccw.lizhihui.cmcc.view.HomeView;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by lizhihui on 3/30/16.
 *
 */
public class HomePresenter implements Presenter {

    private HomeView homeView;

    private final HomeCase getHomeListUseCase;

    private final HomeCase getTaskNumberUseCase;

    private final HomeModelDataMapper homeModelDataMapper;

    @Inject public HomePresenter(@Named("homeTaskNumber") HomeCase getTaskNumberUseCase,
                                 @Named("homeList") HomeCase getHomeListUseCase,
                                 HomeModelDataMapper homeModelDataMapper){
        this.getHomeListUseCase = getHomeListUseCase;
        this.homeModelDataMapper = homeModelDataMapper;
        this.getTaskNumberUseCase = getTaskNumberUseCase;
    }

    public void setView(@NonNull HomeView view){
        this.homeView = view;
    }

    @Override
    public void resume() {}

    @Override
    public void pause() {}

    @Override
    public void destroy() {}

    private final class HomeListSubscriber extends DefaultSubscriber<Collection<HomeItem>> {
        @Override
        public void onCompleted() {
            HomePresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            HomePresenter.this.hideViewLoading();
            HomePresenter.this.showErrorMessage();
            HomePresenter.this.showViewRetry();
        }

        @Override
        public void onNext(Collection<HomeItem> homeModels) {
            HomePresenter.this.showHomesCollectionInView(homeModels);
        }
    }

    private final class HomeTaskNumberSubscriber extends DefaultSubscriber<Integer>{
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(Integer integer) {
            HomePresenter.this.showTaskNumberInView(integer);
        }
    }

    private void showTaskNumberInView(Integer integer){
        this.homeView.renderMyTaskNumebr(integer);
    }

    private void showHomesCollectionInView(Collection<HomeItem> homeItems) {
        final Collection<HomeModel> homeModelCollection = this.homeModelDataMapper.transform(homeItems);
        this.homeView.renderHomeList(homeModelCollection);
    }

    public void initialize(){
        this.loadHomeList();
    }

    private void loadHomeList(){
        this.hideViewRetry();
        this.showViewLoading();
        this.getHomeList();
        this.getTaskNumebr();
    }

    private void getTaskNumebr() {
        this.getTaskNumberUseCase.execute(new HomeTaskNumberSubscriber());
    }

    private void showViewLoading() {
        this.homeView.showLoading();
    }

    private void hideViewRetry(){
        this.homeView.hidenRetry();
    }

    private void getHomeList(){
        this.getHomeListUseCase.execute(new HomeListSubscriber());
    }


    private void showViewRetry() {

    }

    private void showErrorMessage() {

    }

    private void hideViewLoading() {
        this.homeView.hideLoading();
    }
}
