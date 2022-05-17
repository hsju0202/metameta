interface IClick {
    void iClick();
}

class Button {

    IClick ibClick;

    void regClick(IClick iClick) {
        this.ibClick = iClick;
    }

    void click() {
        System.out.println("버튼이 들어갔다 나옴");
    }
}

class LoginButton extends Button {

    @Override
    void click() {
        super.click();
        ibClick.iClick();
    }
}

class LoginClick implements IClick {

    @Override
    public void iClick() {
        System.out.println("로그인 처리");
    }
}

public class InterfaceTest {

    public static void main(String[] args) {
        LoginButton loginBtn = new LoginButton();
        loginBtn.regClick(new IClick() {
            @Override
            public void iClick() {
                System.out.println("로그인 처리 ");
            }
        });
        loginBtn.click();
    }
}
