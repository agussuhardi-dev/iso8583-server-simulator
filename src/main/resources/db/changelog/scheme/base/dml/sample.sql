insert into ISO8583_RESPONSE_TEMPLATE(ID, NAME, EXPLAIN, TEMPLATE, CREATED_AT, UPDATED_AT)
VALUES ('7f000101-9071-1b7b-8190-716c3a990000', '[BNI Debit-Network] ECHO', '',
        '{
          "7": "0701110808",
          "11": "000007",
          "70": "001"
        }', '1719889836699', NULL);

insert into ISO8583(ID, ACQUIRER_CODE, ACQUIRER_NAME, RESPONSE, RC, MTI, IS_ENABLED, CREATED_AT, UPDATED_AT)
VALUES ('7f000101-9071-1ed7-8190-716f4b8b0000', 'BNI_DEBIT', 'BNI', '{}', '00', '0800', false, '1719890037644', NULL);
