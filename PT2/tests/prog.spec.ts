import { test, expect, Page } from '@playwright/test';


test('basic test', async ({ page }) => {
    //function code
    //const browser = await chromium.launch({headless:false, slowMo:100});
    //const page = await browser.newPage();
    await page.goto('https://playwright.dev/');
    const title = page.locator('.navbar__inner .navbar__title');
    await expect(title).toHaveText('Playwright');
    //Test sample tyu

});