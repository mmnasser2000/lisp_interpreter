(setq A 29)
(setq B (+ A 13))
B
((lambda nil (+ 42 0)))
((lambda (X) (+ X 0)) 42)
((lambda (X Y) (+ X Y)) 50 -8)

(setq x 5)
(setq timesGenerator	
    (lambda (x)
  		(function 
            (lambda (y) (* x y))
        )
    )
)
(setq twice (funcall timesGenerator 2))
(setq isList (lambda (mylist)
	(cond 
		(T T)
	)
))
(setq toString (lambda (input)
	;(concatenate "(" input ")")
	(print (cons input))
	)
)

(setq givenSafe 
	(lambda (checkDistance checkDuration checkExhalationLevel) 
		(cond 
			((and (= checkDistance 13) (= checkDuration 30) (= checkExhalationLevel 30)) T)
			((and (= checkDistance 6) (= checkDuration 30) (= checkExhalationLevel 10)) T)
			((and (= checkDistance 27) (= checkDuration 30) (= checkExhalationLevel 50)) T)
			((and (= checkDistance 13) (= checkDuration 15) (= checkExhalationLevel 50)) T)
			((and (= checkDistance 13) (= checkDuration 120) (= checkExhalationLevel 10)) T)
			((and (= checkDistance 27) (= checkDuration 120) (= checkExhalationLevel 30)) T)
			((and (= checkDistance 6) (= checkDuration 15) (= checkExhalationLevel 30)) T)
			(T nil)
		)
	)
)
(setq updateDistance 
	(lambda (toBeUpdatedDistance)
		(cond 
			((> toBeUpdatedDistance 27) 27)
			((> toBeUpdatedDistance 13) 13)
			((> toBeUpdatedDistance 6) 6)
			(T 0)
		)
	)
)
(setq updateDuration
	(lambda (toBeUpdatedDuration)
		(cond 
			((< toBeUpdatedDuration 15) 15)
			((< toBeUpdatedDuration 30) 30)
			((< toBeUpdatedDuration 120) 120)
			(T 200)
		)
	)
)
(setq updateExhalationLevel
	(lambda (toBeUpdatedExhalationLevel)
		(cond 
			((< toBeUpdatedExhalationLevel 10) 10)
			((< toBeUpdatedExhalationLevel 30) 30)
			((< toBeUpdatedExhalationLevel 50) 50)
			(T 200)
		)
	)
)

(setq listDerivedSafeCopy
	(lambda (distance duration exhalationLevel countDistance countDuration countExhalation)
		(or
			(funcall givenSafe distance duration exhalationLevel)
			
		)
	)
)
(setq listDerivedSafe
	(lambda (inputDistance inputDuration inputExhalationLevel)
		(funcall listDerivedSafeCopy inputDistance inputDuration inputExhalationLevel 0 0 0)
	)
)