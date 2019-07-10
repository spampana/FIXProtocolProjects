
<b>FIX client Server Implementation QuickFix</b>
<br>

If you are working in trading based company then it’s very important to have knowledge of FIX (Financial Information eXchange) protocol.

<b>What is FIX: </b>

It’s electronic communications protocol which was initiated in 1992 for international real time exchange of financial information 
related to markets and securities transactions. As you know now a days billions and trillions of dollars traded annually on the trading 
exchanges. Financial institutions entities are investing too much of money optimizing electronic trading application and 
employing direct market access (DMA) in hope of increase to submit orders to speedily to the financial markets. 
It’s very important to manages delivery of trading orders and keeping low latency increasingly requires very strong understanding 
of FIX protocol.

I understand, you wanted to see actual implementation of it without reading more details about it but if you are still very curious 
to know more about it just google it you will see many details of FIX protocol. Finding details of FIX protocol through Google is 
very easy but actual implementation is rare where you could see end to end working application. Before writing this application I 
searched lot never find any good tutorial example which would give basics of FIX protocol and simple to understand. 
That’s why I am writing this tutorial to get how FIX protocol works. Let’s jump on it:

Basically to develop end to end and perform test you need two application:

<b>FIX Acceptor (Called as FIX Server)</b> – Server process the FIX message its nothing but exchange you sent your order for processing
<br/>
<b>FIX Initiator (Called as FIX Client)</b> – Client are broker who send order to the exachange in FIX format.

<br/>
<br/>
<b>FIXProtocolAcceptor Console Logs</b>
<br/>
<br/>
<pre>
D:\GIT\FIXProtocolProjects\FIXClientServerImplementationQuickFix\FIXProtocolAcceptor\.\config\acceptor.cfg
Jul 09, 2019 9:37:43 PM quickfix.SessionSchedule <init>
INFO: [FIX.4.2:FixAcceptor->FixClient8019] daily, 00:00:00-UTC - 00:00:00-UTC
<20190709-16:07:43, FIX.4.2:FixAcceptor->FixClient8019, event> (Session FIX.4.2:FixAcceptor->FixClient8019 schedule is daily, 00:00:00-UTC - 00:00:00-UTC)
<20190709-16:07:43, FIX.4.2:FixAcceptor->FixClient8019, event> (Session state is not current; resetting FIX.4.2:FixAcceptor->FixClient8019)
<20190709-16:07:43, FIX.4.2:FixAcceptor->FixClient8019, event> (Created session: FIX.4.2:FixAcceptor->FixClient8019)
Jul 09, 2019 9:37:43 PM quickfix.mina.SessionConnector startSessionTimer
INFO: SessionTimer started
Jul 09, 2019 9:37:43 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketKeepAlive=true
Jul 09, 2019 9:37:43 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketReuseAddress=true
Jul 09, 2019 9:37:43 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketTcpNoDelay=true
Jul 09, 2019 9:37:43 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketSynchronousWrites=false
Jul 09, 2019 9:37:43 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketSynchronousWriteTimeout=30000
Jul 09, 2019 9:37:43 PM quickfix.mina.acceptor.AbstractSocketAcceptor startAcceptingConnections
INFO: Listening for connections at 0.0.0.0/0.0.0.0:5001 for session(s) [FIX.4.2:FixAcceptor->FixClient8019]
press any key to stop the FIX Acceptor Server....s
Jul 09, 2019 9:37:43 PM quickfix.mina.SingleThreadedEventHandlingStrategy$1 run
INFO: Started QFJ Message Processor
Jul 09, 2019 9:37:51 PM quickfix.mina.acceptor.AcceptorIoHandler sessionCreated
INFO: MINA session created: local=/127.0.0.1:5001, class org.apache.mina.transport.socket.nio.NioSocketSession, remote=/127.0.0.1:65099
<20190709-16:07:52, FIX.4.2:FixAcceptor->FixClient8019, incoming> (8=FIX.4.29=7935=A34=149=FixClient801952=20190709-16:07:52.62756=FixAcceptor98=0108=6010=199)
<20190709-16:07:52, FIX.4.2:FixAcceptor->FixClient8019, event> (Accepting session FIX.4.2:FixAcceptor->FixClient8019 from /127.0.0.1:65099)
<20190709-16:07:52, FIX.4.2:FixAcceptor->FixClient8019, event> (Acceptor heartbeat set to 60 seconds)
fromAdmin 8=FIX.4.29=7935=A34=149=FixClient801952=20190709-16:07:52.62756=FixAcceptor98=0108=6010=199
<20190709-16:07:52, FIX.4.2:FixAcceptor->FixClient8019, event> (Received logon)
<20190709-16:07:52, FIX.4.2:FixAcceptor->FixClient8019, event> (Responding to Logon request)
<20190709-16:07:52, FIX.4.2:FixAcceptor->FixClient8019, outgoing> (8=FIX.4.29=7935=A34=149=FixAcceptor52=20190709-16:07:52.64956=FixClient801998=0108=6010=203)
onLogon of FIX.4.2:FixAcceptor->FixClient8019
<20190709-16:07:54, FIX.4.2:FixAcceptor->FixClient8019, incoming> (8=FIX.4.29=14635=D34=249=FixClient801952=20190709-16:07:54.62756=FixAcceptor11=APPL12456S21=338=450040=144=200.954=155=APPL60=20190709-16:07:54.62610=071)
Inside onmessage method
<20190709-16:07:54, FIX.4.2:FixAcceptor->FixClient8019, outgoing> (8=FIX.4.29=9535=B34=249=FixAcceptor52=20190709-16:07:54.64256=FixClient8019148=Hello to OTC Expiration10=197)
<20190709-16:07:54, FIX.4.2:FixAcceptor->FixClient8019, incoming> (8=FIX.4.29=11535=334=349=FixClient801952=20190709-16:07:54.64656=FixAcceptor45=258=Required tag missing371=33372=B373=110=107)
<20190709-16:07:54, FIX.4.2:FixAcceptor->FixClient8019, outgoing> (8=FIX.4.29=15035=834=349=FixAcceptor52=20190709-16:07:54.64856=FixClient80196=200.911=APPL12456S14=450017=120=037=138=450039=254=155=APPL150=2151=010=080)
NewOrderSingle Execution  Completed...
fromAdmin 8=FIX.4.29=11535=334=349=FixClient801952=20190709-16:07:54.64656=FixAcceptor45=258=Required tag missing371=33372=B373=110=107
<20190709-16:07:58, FIX.4.2:FixAcceptor->FixClient8019, incoming> (8=FIX.4.29=6735=534=449=FixClient801952=20190709-16:07:58.61256=FixAcceptor10=159)
fromAdmin 8=FIX.4.29=6735=534=449=FixClient801952=20190709-16:07:58.61256=FixAcceptor10=159
<20190709-16:07:58, FIX.4.2:FixAcceptor->FixClient8019, event> (Received logout request)
<20190709-16:07:58, FIX.4.2:FixAcceptor->FixClient8019, outgoing> (8=FIX.4.29=6735=534=449=FixAcceptor52=20190709-16:07:58.61656=FixClient801910=163)
<20190709-16:07:58, FIX.4.2:FixAcceptor->FixClient8019, event> (Sent logout response)
Jul 09, 2019 9:37:58 PM quickfix.Session disconnect
INFO: [FIX.4.2:FixAcceptor->FixClient8019] Disconnecting: Received logout request
</pre>
<br/>
<br/>
<b>Fix Protocol Initiator</b>
<br/>
<br/>
<pre>
<20190709-16:07:51, FIX.4.2:FixClient8019->FixAcceptor, event> (Session FIX.4.2:FixClient8019->FixAcceptor schedule is daily, 00:00:00 UTC - 00:00:00 UTC (daily, 00:00:00 UTC - 00:00:00 UTC))
<20190709-16:07:51, FIX.4.2:FixClient8019->FixAcceptor, event> (Session state is not current; resetting FIX.4.2:FixClient8019->FixAcceptor)
<20190709-16:07:51, FIX.4.2:FixClient8019->FixAcceptor, event> (Created session: FIX.4.2:FixClient8019->FixAcceptor)
Inside onCreate
Jul 09, 2019 9:37:51 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketTcpNoDelay=true
Jul 09, 2019 9:37:51 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketSynchronousWrites=false
Jul 09, 2019 9:37:51 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketSynchronousWriteTimeout=30000
Jul 09, 2019 9:37:51 PM quickfix.mina.initiator.InitiatorIoHandler sessionCreated
INFO: MINA session created: /127.0.0.1:65099
<20190709-16:07:52, FIX.4.2:FixClient8019->FixAcceptor, outgoing> (8=FIX.4.29=7935=A34=149=FixClient801952=20190709-16:07:52.62756=FixAcceptor98=0108=6010=199)
<20190709-16:07:52, FIX.4.2:FixClient8019->FixAcceptor, event> (Initiated logon request)
<20190709-16:07:52, FIX.4.2:FixClient8019->FixAcceptor, incoming> (8=FIX.4.29=7935=A34=149=FixAcceptor52=20190709-16:07:52.64956=FixClient801998=0108=6010=203)
Inside fromAdmin
<20190709-16:07:52, FIX.4.2:FixClient8019->FixAcceptor, event> (Received logon request)
Logon requested by client
Sending Order to Server
<20190709-16:07:54, FIX.4.2:FixClient8019->FixAcceptor, outgoing> (8=FIX.4.29=14635=D34=249=FixClient801952=20190709-16:07:54.62756=FixAcceptor11=APPL12456S21=338=450040=144=200.954=155=APPL60=20190709-16:07:54.62610=071)
<20190709-16:07:54, FIX.4.2:FixClient8019->FixAcceptor, incoming> (8=FIX.4.29=9535=B34=249=FixAcceptor52=20190709-16:07:54.64256=FixClient8019148=Hello to OTC Expiration10=197)
<20190709-16:07:54, FIX.4.2:FixClient8019->FixAcceptor, event> (Message 2 Rejected: Required tag missing:33)
<20190709-16:07:54, FIX.4.2:FixClient8019->FixAcceptor, outgoing> (8=FIX.4.29=11535=334=349=FixClient801952=20190709-16:07:54.64656=FixAcceptor45=258=Required tag missing371=33372=B373=110=107)
<20190709-16:07:54, FIX.4.2:FixClient8019->FixAcceptor, incoming> (8=FIX.4.29=15035=834=349=FixAcceptor52=20190709-16:07:54.64856=FixClient80196=200.911=APPL12456S14=450017=120=037=138=450039=254=155=APPL150=2151=010=080)
150=2
Received execution report for the requested order from Exchange 

Going to stop socketInitiator
Jul 09, 2019 9:37:57 PM quickfix.mina.SessionConnector logoutAllSessions
INFO: Logging out all sessions
<20190709-16:07:58, FIX.4.2:FixClient8019->FixAcceptor, event> (Initiated logout request)
<20190709-16:07:58, FIX.4.2:FixClient8019->FixAcceptor, outgoing> (8=FIX.4.29=6735=534=449=FixClient801952=20190709-16:07:58.61256=FixAcceptor10=159)
<20190709-16:07:58, FIX.4.2:FixClient8019->FixAcceptor, incoming> (8=FIX.4.29=6735=534=449=FixAcceptor52=20190709-16:07:58.61656=FixClient801910=163)
Inside fromAdmin
<20190709-16:07:58, FIX.4.2:FixClient8019->FixAcceptor, event> (Received logout response)
<20190709-16:07:58, FIX.4.2:FixClient8019->FixAcceptor, event> (Disconnecting)
</pre>
