call asadmin create-jms-resource --restype javax.jms.Queue --property Name=PhysicalQueue jms/BookQueue
call asadmin create-jms-resource --restype javax.jms.ConnectionFactory jms/BookQueueFactory
pause