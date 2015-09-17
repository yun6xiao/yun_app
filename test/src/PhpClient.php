<?php
$GLOBALS['THRIFT_ROOT'] = '/home/tjiang/demo/thrift/lib/php/src';
require_once $GLOBALS['THRIFT_ROOT'].'/Thrift.php';
require_once $GLOBALS['THRIFT_ROOT'].'/protocol/TBinaryProtocol.php';
require_once $GLOBALS['THRIFT_ROOT'].'/transport/TSocket.php';
require_once $GLOBALS['THRIFT_ROOT'].'/transport/THttpClient.php';
require_once $GLOBALS['THRIFT_ROOT'].'/transport/TBufferedTransport.php';
include_once $GLOBALS['THRIFT_ROOT'].'/packages/TestThrift/TestThrift_types.php';
include_once $GLOBALS['THRIFT_ROOT'].'/packages/TestThrift/IndexNewsOperatorServices.php';
$data=array(
'id'=>'1',
'title'=>'demo-标题',
'content'=>'demo-内容',
'media_from'=>'hexun',
'author'=>'xiaodi667'
);
$thrif_server_url = '192.168.1.100';
$transport = new TSocket($thrif_server_url, 9813);
$transport->open();

$protocol = new TBinaryProtocol($transport);

$client= new IndexNewsOperatorServicesClient($protocol, $protocol);
$obj = new NewsModel($data);
$result = $client->indexNews($obj);

$transport->close();
?>
