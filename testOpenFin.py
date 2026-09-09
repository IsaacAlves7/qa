import time 
from selenium import webdriver

chrome_options = webdriver.ChromeOptions()
chrome_options.binary_location = ".\RunOpenFin.bat"
chrome_options.add_argument("--config=http://localhost:8080/app.json")

EXE_PATH = r'.\chromedriver.exe'
driver = webdriver.Chrome(executable_path=EXE_PATH,chrome_options=chrome_options)

openfin_version = driver.execute_script("return fin.desktop.getVersion()")
print("OpenFin Runtime Version: " + openfin_version)

notification_button = driver.find_element_by_id("desktop-notification")
notification_button.click()

cpu_info_button = driver.find_element_by_id("cpu-info")
cpu_info_button.click()

cpu_window = driver.switch_to.window("cpuChild")

driver.save_screenshot("showCPUInfo.png")

time.sleep(2)

cpu_window_close_button = driver.find_element_by_id("close-app")
cpu_window_close_button.click()

driver.execute_script("fin.desktop.System.exit()")

time.sleep(2)
driver.quit()