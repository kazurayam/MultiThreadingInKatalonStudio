/**
 * https://dzone.com/articles/groovy-goodness-interrupted-sleeping
 * 
 * @author kazuakiurayama
 *
 */
class User {
	String username

	void bedtime() {
		long start = System.currentTimeMillis()
		println 'Sleeping'
		sleep(5000)
		long slept = System.currentTimeMillis() - start
		println "Awake after $slept ms"
	}
}

def user = new User(username: 'mrhaki')

// Run bedtime method in thread.
def bedtime = Thread.start {
	user.bedtime()
}

def alarm = new Timer()
alarm.runAfter(2000) {
	println 'BEEP BEEP'
	// Interrupt thread with bedtime method.
	bedtime.interrupt()
}

bedtime.join()