from altunityrunner import AltUnityDriver
import time

driver = AltUnityDriver()

def test_start_game():
    start_button = driver.wait_for_object(By.NAME, 'StartButton')
    start_button.tap()
    time.sleep(2)
    assert driver.find_object(By.NAME, 'Player') is not None

def test_avoid_obstacle():
    driver.press_key('ArrowRight')
    time.sleep(1)
    assert driver.find_object(By.NAME, 'Obstacle') is not None

def teardown():
    driver.stop()
