-- Keep a log of any SQL queries you execute as you solve the mystery.

-- See the crime scene report of the crime happening in Chamberlin Street
-- on July 28, 2020

SELECT *
FROM crime_scene_reports
WHERE street = 'Chamberlin Street'
AND day = 28
AND month = 7
AND year = 2020;

-- Retrieve the interviews mentioning the word courthouse and taking place on the day of the theft
SELECT *
FROM interviews
WHERE transcript LIKE '%courthouse%'
AND day = 28
AND month = 7
AND year = 2020;

-- In the interview by Ruth, she mentions seeing the thief getting into a car parked
-- In the courthouse parking
-- Thus I am searching the security footage table in the ten minutes after the theft

SELECT *
FROM courthouse_security_logs
WHERE day = 28
AND month = 7
AND year = 2020
AND hour = 10
AND minute >= 15
AND minute <= 30
AND activity = 'exit';

-- Identify the persons
SELECT name
FROM people
INNER JOIN (
            SELECT *
            FROM courthouse_security_logs
            WHERE day = 28
            AND month = 7
            AND year = 2020
            AND hour = 10
            AND minute >= 15
            AND minute <= 30
            AND activity = 'exit') as cars
ON cars.license_plate = people.license_plate;

-- Check the first flight out of fiftyville of the next day
SELECT *
FROM flights
INNER JOIN airports AS origin
ON flights.origin_airport_id = origin.id
INNER JOIN airports AS destination
ON flights.destination_airport_id = destination.id
WHERE flights.day = 29
AND flights.month = 7
AND flights.year = 2020
AND origin.city = 'Fiftyville'
ORDER BY flights.hour, flights.minute
LIMIT 1;

-- They escaped to London on flight nr 36

-- Determine the hour in which the thief used the atm
SELECT *
FROM courthouse_security_logs
INNER JOIN people
ON people.license_plate = courthouse_security_logs.license_plate
WHERE people.name = 'Eugene';
WHERE courthouse_security_logs.activity = 'entrance'
AND courthouse_security_logs.day = 28
AND courthouse_security_logs.month = 7
AND courthouse_security_logs.year = 2020
AND people.name = 'Eugene';

SELECT people.name
FROM phone_calls
INNER JOIN people
ON phone_calls.caller = people.phone_number
WHERE day = 28
AND month = 7
AND year = 2020
and duration < 60;

SELECT name
FROM people
INNER JOIN (
            SELECT *
            FROM courthouse_security_logs
            WHERE day = 28
            AND month = 7
            AND year = 2020
            AND hour = 10
            AND minute >= 15
            AND minute <= 30
            AND activity = 'exit') as cars
ON cars.license_plate = people.license_plate
WHERE people.name IN (SELECT people.name
                      FROM phone_calls
                      INNER JOIN people
                      ON phone_calls.caller = people.phone_number
                      WHERE day = 28
                      AND month = 7
                      AND year = 2020
                      and duration < 60)

AND people.name IN (SELECT people.name
                    FROM passengers
                    INNER JOIN people
                    ON passengers.passport_number = people.passport_number
                    WHERE flight_id = 36)
AND people.name IN (SELECT name
FROM people
WHERE id IN
            (SELECT person_id
            FROM atm_transactions
            INNER JOIN bank_accounts
            ON atm_transactions.account_number = bank_accounts.account_number
            WHERE day = 28
            AND month = 7
            AND year = 2020
            AND atm_location = 'Fifer Street'
            AND transaction_type = 'withdraw'));

-- The thief is Ernest!!!

SELECT receiver.name
FROM phone_calls
INNER JOIN people AS caller
ON phone_calls.caller = caller.phone_number
INNER JOIN people AS receiver
ON phone_calls.receiver = receiver.phone_number
WHERE day = 28
AND month = 7
AND year = 2020
AND duration < 60
AND caller.name = 'Ernest';

-- The accomplice is Berthold
