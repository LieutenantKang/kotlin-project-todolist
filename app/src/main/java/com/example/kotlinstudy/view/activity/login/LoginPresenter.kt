package com.example.kotlinstudy.view.activity.login

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {

    override fun start() {
        view.presenter = this
    }

//    private val userModel: UserModel = UserModel(context)

//    override fun presenterView() {
//        view.setView()
//    }

    override fun login(email: String, pw: String, autoLogin: Boolean) {
//        val checkLogin = userModel.checkLogin(email, pw)
//
//        if (checkLogin) {
//            userModel.saveEmail(email)
//            userModel.saveAutoLogin(autoLogin)
//
//            val intent = Intent(context, MainActivity::class.java)
//            view.startIntent(intent)
//        } else {
//            view.showToast("일치하는 계정이 없습니다")
//        }
    }

    override fun showEmail(): String? = "dummy"
//    override fun showEmail(): String? {
//        return userModel.getSavedEmail()
//    }
}
