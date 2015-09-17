package tianyi;

import java.io.IOException;

import com.common.web.util.WebUtils;
import com.common.web.util.WebUtils.Response;

public class TestAct {

	
	public static void main(String[] args) throws IOException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=20000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/admin/p2p_repayment/doRepayment.jhtml?uid=3&p2pId=18&nper=2&paymentTime=2015-02-25&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=20000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=20000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=20000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=20000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=20000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=20000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=20000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=20000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=20000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=20000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=20000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=20000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Response resp = null;
				try {
					resp = WebUtils
							.doGet("http://daily.qcfq.com/p2p/p2p_investment/save.jhtml?uid=8&p2pId=18&investmentFee=18000&paymentPassword=123456&format=json");
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
				System.out.println(resp.getText());
			}
		}).start();
	}
}
